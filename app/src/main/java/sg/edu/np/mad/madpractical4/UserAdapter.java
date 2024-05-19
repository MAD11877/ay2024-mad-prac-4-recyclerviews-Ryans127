package sg.edu.np.mad.madpractical4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_activity_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.textViewName.setText(user.getName());
        holder.textViewDescription.setText(user.getDescription());
        holder.imageViewSmall.setImageResource(R.drawable.ic_launcher_foreground); // Replace with actual small image resource if available
        holder.imageViewLarge.setImageResource(R.drawable.ic_launcher_foreground); // Replace with actual large image resource if available

        // Set click listener for the item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
                builder.setTitle("Profile")
                        .setMessage("MADness")
                        .setPositiveButton("VIEW", (dialog, which) -> {
                            // Generate a random integer
                            Random random = new Random();
                            int randomInt = random.nextInt(100); // Generates a random integer from 0 to 99

                            // Create an Intent to start MainActivity
                            Intent intent = new Intent(holder.itemView.getContext(), MainActivity.class);
                            intent.putExtra("RandomNumber", randomInt);
                            holder.itemView.getContext().startActivity(intent);
                        })
                        .setNegativeButton("CLOSE", (dialog, which) -> dialog.dismiss())
                        .setCancelable(true);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
