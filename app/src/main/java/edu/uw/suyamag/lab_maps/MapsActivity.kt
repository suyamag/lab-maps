package edu.uw.suyamag.lab_maps

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions



class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
//        val MGH = LatLng(47.655, -122.3078)
//        mMap.addMarker(MarkerOptions().position(MGH).title("Marker in Mary Gates Hall"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(MGH))
        // Instantiates a new Polyline object and adds points to define a rectangle
        val rectOptions = PolylineOptions()
            .add(LatLng(47.655, -122.3078))
            .add(LatLng(47.653, -122.3084))
            .add(LatLng(47.654, -122.3090))
            .add(LatLng(47.653, -122.3096))
            .add(LatLng(47.655, -122.3102))
            .color(Color.MAGENTA)

        // Get back the mutable Polyline
        mMap.addPolyline(rectOptions)

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(47.6538, -122.3078))
                .title("Drumheller Fountain")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
                .snippet("I don't see any ducks here, just asshole geese")
        )

        mMap.setInfoWindowAdapter()
    }
}
