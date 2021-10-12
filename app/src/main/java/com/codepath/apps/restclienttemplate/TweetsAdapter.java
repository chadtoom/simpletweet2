package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{
    Context context;
    List<Tweet> tweets;
    public TweetsAdapter(Context context, List<Tweet> tweets){
        this.context = context;
        this.tweets = tweets;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweets, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);
        holder.bind(tweet);

    }


    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Tweet> tweetlist) {
        tweets.addAll(tweetlist);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView ivProfileimagine;
        TextView tvbody;
        TextView tvscreenName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileimagine = itemView.findViewById(R.id.ivProfileimagine);
            tvbody = itemView.findViewById(R.id.tvBody);
            tvscreenName = itemView.findViewById(R.id.tvScreenName);

        }


        public void bind(Tweet tweet) {
            tvbody.setText(tweet.body);
            tvscreenName.setText(tweet.user.screenName);
            Glide.with(context).load(tweet.user.profileImageUrl).into(ivProfileimagine);


        }
    }
}
