package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.w3c.dom.Text;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.Viewholder>{









    private Context context;
    private List<Tweet> tweets;
    //Pass in context and list of tweets

    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }


    //for each row, inflate the layout
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);


        return new Viewholder(view);
    }

    //bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
    Tweet tweet = tweets.get(position); //get tweets tweet relative to since_id
    holder.tvBody.setText(tweet.body); //grabs tweets body text
    holder.tvScreenName.setText(tweet.user.screenName); //grabs users screen name
    holder.tvUserName.setText(tweet.user.userName); // grab username
    Glide.with(context).load(tweet.user.profileImageURL).into(holder.ivProfileImage); //loads users profile image into the holder using the Glide library

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    //Define the Viewholder
    //Clean all items from recycler view
    public void clear(){
        tweets.clear();
        notifyDataSetChanged();
    }
//Add a list of items -
    public void addTweets(List<Tweet> tweetList){
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }
    public class Viewholder extends RecyclerView.ViewHolder{

        public ImageView ivProfileImage;
        public TextView tvScreenName;
        public TextView tvBody;
        public TextView tvUserName;


        public Viewholder(View itemView){
            super(itemView);

           ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
           tvScreenName = itemView.findViewById(R.id.tvScreenName);
           tvBody = itemView.findViewById(R.id.tvBody);
           tvUserName = itemView.findViewById(R.id.tvUserName);
        }

    }
}
