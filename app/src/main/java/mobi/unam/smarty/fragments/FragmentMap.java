package mobi.unam.smarty.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import mobi.unam.smarty.R;
import mobi.unam.smarty.utilities.Ruta;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMap extends Fragment {

    private View view;
    private GoogleMap mapa;
    private MapView mapView;

    private List<Boolean> enableRoutes;

    private List<Polyline> polylines;


    private List<List<Double>> surOestes;
    private List<List<Double>> notEstes;


    public static final FragmentMap newInstance() {
        FragmentMap fragmentMap = new FragmentMap();
        return fragmentMap;
    }

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
            polylines = new ArrayList<Polyline>();
            notEstes = new ArrayList<List<Double>>();
            surOestes = new ArrayList<List<Double>>();
            for (int i = 0; i < 13; i++) {
                enableRoutes.add(false);
                polylines.add(null);
                notEstes.add(null);
                surOestes.add(null);
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


    private class ObtenerMarkers extends AsyncTask<Void, Ruta, Boolean> {

        private int typeCamera;

        private ObtenerMarkers(int typeCamera) {
            this.typeCamera = typeCamera;

        }

        @Override
        protected Boolean doInBackground(Void... params) {

            BufferedReader reader = null;
            Gson gson = new Gson();
            Ruta ruta;
            int idArchive = 0;
            boolean isVisible = true;

            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(FragmentRoutes.SHARE_RUTAS, Context.MODE_PRIVATE);
            for (int i = 0; i < 13; i++) {


                if (!enableRoutes.get(i) && isVisible) {

                    switch (i) {
                        case 0:
                            idArchive = R.raw.ruta_1;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE1, true);
                            break;
                        case 1:
                            idArchive = R.raw.ruta_2;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE2, true);
                            break;
                        case 2:
                            idArchive = R.raw.ruta_3;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE3, true);
                            break;
                        case 3:
                            idArchive = R.raw.ruta_4;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE4, true);
                            break;
                        case 4:
                            idArchive = R.raw.ruta_5;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE5, true);
                            break;
                        case 5:
                            idArchive = R.raw.ruta_6;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE6, true);
                            break;
                        case 6:
                            idArchive = R.raw.ruta_7;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE7, true);
                            break;
                        case 7:
                            idArchive = R.raw.ruta_8;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE8, true);
                            break;
                        case 8:
                            idArchive = R.raw.ruta_9;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE9, true);
                            break;
                        case 9:
                            idArchive = R.raw.ruta_10;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE10, true);
                            break;
                        case 10:
                            idArchive = R.raw.ruta_11;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE11, true);
                            break;
                        case 11:
                            idArchive = R.raw.ruta_12a;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE12, true);
                            break;
                        case 12:
                            idArchive = R.raw.ruta_12b;
                            isVisible = sharedPreferences.getBoolean(FragmentRoutes.SHARE_ROUTE12b, true);
                            break;
                    }

                    reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(idArchive)));
                    ruta = gson.fromJson(reader, Ruta.class);
                    ruta.setId(i);
                    publishProgress(ruta);

                    if (surOestes.get(i) == null) {
                        surOestes.set(i, ruta.getSurOeste());
                    }

                    if (notEstes.get(i) == null) {
                        notEstes.set(i, ruta.getNotEste());
                    }

                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }

                } else if (enableRoutes.get(i) && !isVisible) {
                    if (polylines.get(i) != null) {
                        polylines.get(i).remove();
                    }
                }

            }

            return true;
        }


        @Override
        protected void onProgressUpdate(Ruta... values) {
            super.onProgressUpdate(values);

            if (values == null && values.length == 0) {
                return;
            }
            Ruta ruta = values[0];
            PolylineOptions polylineOptions = new PolylineOptions();
            polylineOptions.color(Color.rgb(ruta.getColores().get(0), ruta.getColores().get(3), ruta.getColores().get(2)));

            List<Double> coordinates = ruta.getPolilinea();

            for (int i = 0; i < coordinates.size(); i += 2) {

                polylineOptions.add(new LatLng(coordinates.get(i), coordinates.get(i + 1)));
            }

            polylines.set(ruta.getId(), mapa.addPolyline(polylineOptions));

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            double surLatitude;
            double surLongitude;
            double norLatitude;
            double norLongitude;




            if (aBoolean) {

                for (List<Double> surOeste:surOestes)
                {

                }

                for (List<Double> norEste: notEstes)
                {

                }

                if (typeCamera == 1) {

                } else {

                }

            }
        }
    }

}
