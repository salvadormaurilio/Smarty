package mobi.unam.smarty.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;

import mobi.unam.smarty.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMap extends Fragment {


    public static final FragmentMap newInstance() {
        FragmentMap fragmentMap = new FragmentMap();
        return fragmentMap;
    }


    private View view;
    private GoogleMap mapa;
    private MapView mapView;

    public FragmentMap() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        if (view != null) {
            ViewGroup group = (ViewGroup) view.getParent();

            if (group != null) {
                group.removeView(view);
            }

            mapView = (MapView) view.findViewById(R.id.mapview);

        } else {
            view = inflater.inflate(R.layout.fragment_map, container, false);
            mapView = (MapView) view.findViewById(R.id.mapview);
            mapView.onCreate(savedInstanceState);
            MapsInitializer.initialize(getActivity());
        }


        if (mapa == null) {
            mapa = mapView.getMap();
            mapa.setMyLocationEnabled(true);

        }


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

}
