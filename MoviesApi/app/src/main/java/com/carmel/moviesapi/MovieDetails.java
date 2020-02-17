package com.carmel.moviesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {
    private TextView movieTitle,originalLaguage,popularity1,overview,releasedate;
    private ImageView moviesposter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        String movie_title=getIntent().getExtras().getString("movie_name");
        String original_language=getIntent().getExtras().getString("originalLaguage");
        int popularity=getIntent().getExtras().getInt("popularity");
        String overView=getIntent().getExtras().getString("overView");
        String releaseDate=getIntent().getExtras().getString("releaseDate");
        String moviesPoster=getIntent().getExtras().getString("moviesPoster");

        popularity1=findViewById(R.id.popularity);
        moviesposter1=findViewById(R.id.moviesImage1);
        movieTitle=findViewById(R.id.aa_movieTitle);
        originalLaguage=findViewById(R.id.originalLanguage);
        overview=findViewById(R.id.OverView);
        releasedate=findViewById(R.id.releaseDate);

        popularity1.setText("Popularity:"+popularity);
        movieTitle.setText(movie_title);
        originalLaguage.setText(original_language);
        overview.setText(overView);
        releasedate.setText(releaseDate);


        Picasso.with(this).load("https://image.tmdb.org/t/p/w185"
                + moviesPoster)
                .placeholder(R.drawable.movies_poster)
                .into(moviesposter1);
    }
}
