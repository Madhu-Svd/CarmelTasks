package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.moviesapi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;

import Model.ListMovies;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ListMovies> moviesArrayList;
    public MovieAdapter(Context context,ArrayList<ListMovies> listMovies){
        this.context=context;
        this.moviesArrayList=listMovies;
    }
    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            ListMovies listMovies=moviesArrayList.get(position);
            String imageUrl=listMovies.getImageUrl();
            int popularity=listMovies.getPopularity();
            String movieTitle=listMovies.getMoviesTitle();
            String originalLanguage=listMovies.getOriginalLanguage();
            String overView=listMovies.getOverView();

        Picasso.with(context).load(imageUrl).fit().centerInside().into(holder.moviesPoster);
        holder.popularity.setText("popularity:"+popularity);
        holder.movieTitle.setText(movieTitle);
        holder.originalLaguage.setText(originalLanguage);
        holder.overView.setText(overView);
//        holder.releaseDate.setText(re);
    }

    @Override
    public int getItemCount() {
        return moviesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView moviesPoster;
        private TextView movieTitle,originalLaguage,popularity,overView,releaseDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            popularity=itemView.findViewById(R.id.popularity);
            moviesPoster=itemView.findViewById(R.id.moviesImage);
            movieTitle=itemView.findViewById(R.id.movieTitle);
            originalLaguage=itemView.findViewById(R.id.originalLanguage);
            overView=itemView.findViewById(R.id.OverView);
            releaseDate=itemView.findViewById(R.id.releaseDate);
            moviesPoster.setImageResource(R.drawable.movies_poster);
        }
    }
}
