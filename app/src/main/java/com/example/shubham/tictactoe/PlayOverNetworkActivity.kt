package com.example.shubham.tictactoe

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pManager
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class PlayOverNetworkActivity : AppCompatActivity() {

    val SERVER_PORT = 0
    var isWifiP2pEnabled = false
    private val intentFilter = IntentFilter()
    lateinit var channel: WifiP2pManager.Channel
    lateinit var manager: WifiP2pManager
    lateinit var receiver: WifiDirectBroadcastReceiver
    val buddies = HashMap<String, String>()

    private fun discoverService() {
        val txtListener = WifiP2pManager.DnsSdTxtRecordListener { fullDomain, record, device ->
            Log.d("MYLOG", "DnsSdTxtRecord available :- $record")
            buddies.put(device.deviceAddress, record["buddyname"]!!)
        }

        val servListener = WifiP2pManager.DnsSdServiceResponseListener {
            instanceName, registrationType, resourceType ->
            resourceType.deviceName = if (buddies.containsKey(resourceType.deviceAddress)) {
                buddies.get(resourceType.deviceAddress)
            } else {
                buddies.get(resourceType.deviceName)
            }

        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_over_network)

        // Indicates a change in the Wi-Fi P2P status
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION)

        // Indicates a change in the list of available peers
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION)

        // Indicates the state of Wi-Fi P2P connectivity has changed
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION)

        // Indicates this device's details have changed
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION)

        manager = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager
        channel = manager.initialize(this, mainLooper, null)
        receiver = WifiDirectBroadcastReceiver(manager, channel, this)

    }

    /**
     * Register the broadcast receiver with the intent values to be matched
     */
    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, intentFilter)
    }

    /**
     * Unregister the broadcast receiver
     */
    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    private fun startRegistration() {
        // Create a string map containing information about your service
        val record = hashMapOf( Pair("listenport", SERVER_PORT.toString()),
                                                Pair("buddyname", "TonyStark"),
                                                Pair("available", "visible"))

        /**
         * Service information.
         * Pass it an instance name,
         * service type, _protocol._transportlayer, and
         * the map containing information other devices will want once they connect to this one.
         */
        val serviceInfo =
                WifiP2pDnsSdServiceInfo.newInstance("_test",
                "_presence._tcp",
                record)

        /**
         * Add the local service, sending the service info, network channel,
         * and listener that will be used to indicate success or failure of
         * the request.
         */
        manager.addLocalService(channel, serviceInfo, object: WifiP2pManager.ActionListener {
            override fun onSuccess() {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(p0: Int) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })


    }
}

class WifiDirectBroadcastReceiver(
        val manager: WifiP2pManager,
        val channel: WifiP2pManager.Channel,
        val activity: PlayOverNetworkActivity
): BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action

        when(action) {

            WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION -> {
                // Determine if Wifi P2P mode is enabled or not, alert the activity
                val state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1)
                activity.isWifiP2pEnabled = state == WifiP2pManager.WIFI_P2P_STATE_ENABLED
            }

            WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION -> {
                // The peer list has changed, we should probably do something about it.
            }

            WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION -> {
                // Connection state changed. We should probably do something about it.
            }

            WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION -> {
                // Respond to this device's wifi state changing
            }
        }
    }
}
