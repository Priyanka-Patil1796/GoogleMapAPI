package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.googlemapapi.NearByLocationFragment;
import com.example.googlemapapi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Model.Result;

public class RecycleAdapter extends  RecyclerView.Adapter<RecycleAdapter.ViewHolder>
{
    private List<Result> resultlist;
    Context context;
    private AdapterCallback mAdapterCallback;
    private int position;

    public RecycleAdapter(List<Result> resultlist, Context context,
                          NearByLocationFragment nearByHospitalFragment)
    {
        this.resultlist = resultlist;
        this.context = context;
        this.mAdapterCallback=nearByHospitalFragment;
    }

    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.list, viewGroup,false);

        return  new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder viewHolder, int i)
    {
        Result result = resultlist.get(i);
        position=i;
        viewHolder.resultid.setText(String.valueOf(result.getId()));
        viewHolder.resultname.setText(result.getName());
        viewHolder.resultvicinity.setText(result.getVicinity());
       // result.getGeometry().getLocation();

        Picasso.with(context).load(result.getIcon()).resize(120, 80).
                into(viewHolder.iv_icon);
    }

    @Override
    public int getItemCount()
    {
        return resultlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView resultid;
        TextView resultname;
        TextView resultvicinity;
        ImageView iv_icon;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            resultid=itemView.findViewById(R.id.id);
            resultname=itemView.findViewById(R.id.name);
            resultvicinity=itemView.findViewById(R.id.vicinity);
            iv_icon=itemView.findViewById(R.id.iv_icon);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v)
        {
            Toast.makeText(context, "you have clicked Row " + getAdapterPosition(), Toast.LENGTH_LONG).show();
            mAdapterCallback.callgooglemap(resultlist.get(getAdapterPosition()));
        }
    }
    public interface AdapterCallback
    {
        void callgooglemap(Result result);
    }
}
