package mobi.unam.smarty.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import mobi.unam.smarty.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMap extends Fragment {


    private List<Boolean> enableRoutes;

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

            enableRoutes = new ArrayList<Boolean>();
            for (int i = 0; i < 13; i++) {
                enableRoutes.add(false);
            }

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



    private class ObtenerMarkers extends AsyncTask<Void, Void, Boolean> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            BufferedReader reader = null;





            reader = new BufferedReader(new InputStreamReader(getResources()
                    .openRawResource(R.raw.estaciones)));

        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

        }

    }

}
