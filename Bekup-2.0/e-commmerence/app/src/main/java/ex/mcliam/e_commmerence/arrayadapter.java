package ex.mcliam.e_commmerence;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by McLiam on 11/6/2016.
 */

public class arrayadapter extends ArrayAdapter<Customer> {

    private Context context;

    public CursorAdapter(Context context, ArrayList<Customer> customers){
        super(context, 0, customers);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.activity_main, null );
        }

        Customer customer = getItem(position);

        TextView nama = (TextView)convertView.findViewById(R.id.nama);
        nama.setText(customer.getNama().toString());

        TextView harga = (TextView)convertView.findViewById(R.id.harga);
        harga.setText(customer.getHarga().toString());

        TextView penjual = (TextView)convertView.findViewById(R.id.penjual);
        penjual.setText(customer.getPenjual().toString());

        return convertView;

    }
}
