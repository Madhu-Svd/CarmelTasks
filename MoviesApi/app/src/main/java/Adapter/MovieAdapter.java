package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.moviesapi.MovieDetails;
import com.carmel.moviesapi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


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
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MovieDetails.class);
                intent.putExtra("movie_name",moviesArrayList.get(viewHolder.getAdapterPosition()).getMoviesTitle());
                intent.putExtra("originalLaguage",moviesArrayList.get(viewHolder.getAdapterPosition()).getOriginalLanguage());
                intent.putExtra("popularity",moviesArrayList.get(viewHolder.getAdapterPosition()).getPopularity());
                intent.putExtra("overView",moviesArrayList.get(viewHolder.getAdapterPosition()).getOverView());
                intent.putExtra("releaseDate",moviesArrayList.get(viewHolder.getAdapterPosition()).getReleaseDate());
                intent.putExtra("moviesPoster",moviesArrayList.get(viewHolder.getAdapterPosition()).getImageUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            ListMovies listMovies=moviesArrayList.get(position);
            String imageUrl=listMovies.getImageUrl();
            String movieTitle=listMovies.getMoviesTitle();

            holder.movieTitle.setText(movieTitle);

            Picasso.with(context).load("https://image.tmdb.org/t/p/w185"
            + imageUrl)
                .placeholder(R.drawable.movies_poster)
                .into(holder.moviesPoster);

    }

    @Override
    public int getItemCount() {
        return moviesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView moviesPoster;
        CardView cardView;
        private TextView movieTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            moviesPoster=itemView.findViewById(R.id.moviesImage);
            movieTitle=itemView.findViewById(R.id.movieTitle);
            moviesPoster.setImageResource(R.drawable.movies_poster);
            cardView=itemView.findViewById(R.id.movieCardView);
        }
    }
}
