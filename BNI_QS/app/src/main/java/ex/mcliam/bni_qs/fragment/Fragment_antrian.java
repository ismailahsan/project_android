package ex.mcliam.bni_qs.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ex.mcliam.bni_qs.Menu_Antrian;
import ex.mcliam.bni_qs.Pilih_Lokasi;
import ex.mcliam.bni_qs.R;
import ex.mcliam.bni_qs.Tampilan_antrian;

public class Fragment_antrian extends Fragment {
    public Fragment_antrian() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_antrian, container, false);
    }

    public void mengantri(View view) {
        Intent intent = new Intent (getActivity(), Tampilan_antrian.class);
        startActivity(intent);
    }

}