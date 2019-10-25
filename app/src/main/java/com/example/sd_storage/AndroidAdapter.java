package com.example.sd_storage;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;

        import java.util.List;

public class AndroidAdapter extends ArrayAdapter<AndroidVersion> {
    private Context context;
    private int resource;

    public AndroidAdapter(@NonNull Context context, int resource, @NonNull List<AndroidVersion> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }
    @NonNull
    @Override
    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent){
        int logo = getItem(i).getLogo();
        String version = getItem(i).getName();
        String date = getItem(i).getrDate();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        ImageView img = convertView.findViewById(R.id.ivLogo);
        TextView verName = convertView.findViewById(R.id.tvName);
        TextView rDate = convertView.findViewById(R.id.tvDate);

        img.setImageResource(logo);
        verName.setText(version);
        rDate.setText(date);
        return convertView;
    }
}
