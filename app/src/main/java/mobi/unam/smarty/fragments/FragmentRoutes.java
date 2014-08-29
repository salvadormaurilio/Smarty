package mobi.unam.smarty.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import mobi.unam.smarty.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRoutes extends Fragment implements CompoundButton.OnCheckedChangeListener {


    public static final String SHARE_RUTAS = "mis_rutas";
    public static final String SHARE_ROUTE1 = "ruta1";
    public static final String SHARE_ROUTE2 = "ruta2";
    public static final String SHARE_ROUTE3 = "ruta3";
    public static final String SHARE_ROUTE4 = "ruta4";
    public static final String SHARE_ROUTE5 = "ruta5";
    public static final String SHARE_ROUTE6 = "ruta6";
    public static final String SHARE_ROUTE7 = "ruta7";
    public static final String SHARE_ROUTE8 = "ruta8";
    public static final String SHARE_ROUTE9 = "ruta9";
    public static final String SHARE_ROUTE10 = "ruta10";
    public static final String SHARE_ROUTE11 = "ruta11";
    public static final String SHARE_ROUTE12 = "ruta12";
    public static final String SHARE_ROUTE12b = "ruta12b";


    private View view;
    private CheckBox checkBoxRoute1;
    private CheckBox checkBoxRoute2;
    private CheckBox checkBoxRoute3;
    private CheckBox checkBoxRoute4;
    private CheckBox checkBoxRoute5;
    private CheckBox checkBoxRoute6;
    private CheckBox checkBoxRoute7;
    private CheckBox checkBoxRoute8;
    private CheckBox checkBoxRoute9;
    private CheckBox checkBoxRoute10;
    private CheckBox checkBoxRoute11;
    private CheckBox checkBoxRoute12;
    private CheckBox checkBoxRoute12b;

    public FragmentRoutes() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_routes, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARE_RUTAS, Context.MODE_PRIVATE);

        checkBoxRoute1 = (CheckBox) view.findViewById(R.id.checkBoxRoute1);
        checkBoxRoute1.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE1, true));
        checkBoxRoute1.setOnCheckedChangeListener(this);

        checkBoxRoute2 = (CheckBox) view.findViewById(R.id.checkBoxRoute2);
        checkBoxRoute2.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE2, true));
        checkBoxRoute2.setOnCheckedChangeListener(this);

        checkBoxRoute3 = (CheckBox) view.findViewById(R.id.checkBoxRoute3);
        checkBoxRoute3.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE3, true));
        checkBoxRoute3.setOnCheckedChangeListener(this);

        checkBoxRoute4 = (CheckBox) view.findViewById(R.id.checkBoxRoute4);
        checkBoxRoute4.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE4, true));
        checkBoxRoute4.setOnCheckedChangeListener(this);

        checkBoxRoute5 = (CheckBox) view.findViewById(R.id.checkBoxRoute5);
        checkBoxRoute5.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE5, true));
        checkBoxRoute5.setOnCheckedChangeListener(this);

        checkBoxRoute6 = (CheckBox) view.findViewById(R.id.checkBoxRoute6);
        checkBoxRoute6.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE6, true));
        checkBoxRoute6.setOnCheckedChangeListener(this);

        checkBoxRoute7 = (CheckBox) view.findViewById(R.id.checkBoxRoute7);
        checkBoxRoute7.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE7, true));
        checkBoxRoute7.setOnCheckedChangeListener(this);

        checkBoxRoute8 = (CheckBox) view.findViewById(R.id.checkBoxRoute8);
        checkBoxRoute8.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE8, true));
        checkBoxRoute8.setOnCheckedChangeListener(this);

        checkBoxRoute9 = (CheckBox) view.findViewById(R.id.checkBoxRoute9);
        checkBoxRoute9.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE9, true));
        checkBoxRoute9.setOnCheckedChangeListener(this);

        checkBoxRoute10 = (CheckBox) view.findViewById(R.id.checkBoxRoute10);
        checkBoxRoute10.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE10, true));
        checkBoxRoute10.setOnCheckedChangeListener(this);

        checkBoxRoute11 = (CheckBox) view.findViewById(R.id.checkBoxRoute11);
        checkBoxRoute11.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE11, true));
        checkBoxRoute11.setOnCheckedChangeListener(this);

        checkBoxRoute12 = (CheckBox) view.findViewById(R.id.checkBoxRoute12);
        checkBoxRoute12.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE12, true));
        checkBoxRoute12.setOnCheckedChangeListener(this);

        checkBoxRoute12b = (CheckBox) view.findViewById(R.id.checkBoxRoute12b);
        checkBoxRoute12b.setChecked(sharedPreferences.getBoolean(SHARE_ROUTE12b, true));
        checkBoxRoute12b.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        SharedPreferences.Editor editor = getActivity().getSharedPreferences(SHARE_RUTAS, Context.MODE_PRIVATE).edit();

        switch (compoundButton.getId()) {
            case R.id.checkBoxRoute1:
                editor.putBoolean(SHARE_ROUTE1, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxRoute2:
                editor.putBoolean(SHARE_ROUTE2, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxRoute3:
                editor.putBoolean(SHARE_ROUTE3, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxRoute4:
                editor.putBoolean(SHARE_ROUTE4, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxRoute5:
                editor.putBoolean(SHARE_ROUTE5, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxRoute6:
                editor.putBoolean(SHARE_ROUTE6, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 6", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxRoute7:
                editor.putBoolean(SHARE_ROUTE7, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 7", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxRoute8:
                editor.putBoolean(SHARE_ROUTE8, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 8", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxRoute9:
                editor.putBoolean(SHARE_ROUTE9, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 9", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxRoute10:
                editor.putBoolean(SHARE_ROUTE10, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 10", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxRoute11:
                editor.putBoolean(SHARE_ROUTE11, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 11", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxRoute12:
                editor.putBoolean(SHARE_ROUTE12, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 12", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxRoute12b:
                editor.putBoolean(SHARE_ROUTE12b, compoundButton.isChecked());
                Toast.makeText(getActivity(), "Ruta 12b", Toast.LENGTH_SHORT).show();
                break;
        }

        editor.commit();

    }
}
