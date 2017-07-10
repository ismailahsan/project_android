package ex.mcliam.samplefragmentusage;


import android.os.BaseBundle;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private Button btnSecond;
    private Button toast;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        btnSecond = (Button)view.findViewById(R.id.btn_scnd_fragment);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Fragment Kedua");

        toast = (Button)view.findViewById(R.id.toast);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btnSecond) {
                    getFragmentManager().beginTransaction().
                            replace(R.id.frame_container, new ThirdFragment(),
                                    ThirdFragment.class.getSimpleName())
                            .addToBackStack(null).commit();
                }

            }
        });
    }

}
