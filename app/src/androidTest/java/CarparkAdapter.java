import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CarparkAdapter extends ArrayAdapter<Carpark> {

    Context parent_context;
    int layout_id;
    ArrayList<Carpark> al;
    public CarparkAdapter(Context context, int resource, ArrayList<Carpark> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        al = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);
        // Obtain the UI components and do the necessary binding
        TextView tv = rowView.findViewById(R.id.tv);
        // Obtain the Android Version information based on the position
        Carpark currentCarpark = al.get(position);
        // Set values to the TextView to display the corresponding information
        tv.setText(currentCarpark.toString());
        if (currentCarpark.getAvailability().contains("Yes")){

        } else if (currentCarpark.getAvailability().contains("No")){

        }


        return rowView;
    }
}