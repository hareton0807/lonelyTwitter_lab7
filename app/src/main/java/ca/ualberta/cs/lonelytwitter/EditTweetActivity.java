package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    private TextView myTextView;

    String tweet_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        myTextView = (TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        tweet_content = intent.getStringExtra("tweet_content");

        myTextView.setText(tweet_content);




    }
}
