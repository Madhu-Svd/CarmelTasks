package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.carmel.moviedatabase.MainActivity;
import com.carmel.moviedatabase.R;

import java.util.List;

import Model.MoviesList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private Context context;
    private List<MoviesList> moviesLists;
    public MoviesAdapter(Context context, List<MoviesList> moviesLists) {
        this.context= context;
        this.moviesLists=moviesLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoviesList moviesList=moviesLists.get(position);
        holder.movieTitle.setText(String.valueOf(moviesList.getMovieTitle()));
        holder.movieTheater.setText(String.valueOf(moviesList.getMovieTheater()));
        holder.address.setText(String.valueOf(moviesList.getTheaterAddress()));
        

    }

    @Override
    public int getItemCount() {
        return moviesLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView movieTitle,movieTheater,address;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle=itemView.findViewById(R.id.movieTitle);
            movieTheater=itemView.findViewById(R.id.movieTheater);
            address=itemView.findViewById(R.id.theaterAddress);
        }
    }
}