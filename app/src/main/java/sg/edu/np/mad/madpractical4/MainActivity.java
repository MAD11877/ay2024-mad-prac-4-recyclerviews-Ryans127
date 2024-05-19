package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ensure window insets are handled for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve the random integer from the Intent
        int randomInt = getIntent().getIntExtra("RandomNumber", 0); // Default to 0 if no data found

        // Creating a user instance
        User user = new User("John Doe", "MAD Developer", 1, false);

        // Getting references to the UI components
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);

        // Set the TextViews with the User's name and random integer
        tvName.setText(user.getName() + " " + randomInt); // Display name and random integer
        tvDescription.setText(user.getDescription());

        // Set the initial button text based on followed status
        if (user.getFollowed()) {
            btnFollow.setText("UNFOLLOW");
        } else {
            btnFollow.setText("FOLLOW");
        }

        // Set click listener for the Follow button
        btnFollow.setOnClickListener(new View.OnClickListener() {
            boolean isFollowed = user.getFollowed(); // Local variable to track follow status

            @Override
            public void onClick(View v) {
                if (isFollowed) {
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                    btnFollow.setText("FOLLOW");
                } else {
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                    btnFollow.setText("UNFOLLOW");
                }
                isFollowed = !isFollowed; // Toggle the follow status
            }
        });
    }
}
