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
        holder.textViewName.setText(user.name);
        holder.textViewDescription.setText(user.description);
        holder.imageViewSmall.setImageResource(R.drawable.ic_launcher_foreground); // Replace with actual small image resource if available
        holder.imageViewLarge.setImageResource(R.drawable.ic_launcher_foreground); // Replace with actual large image resource if available
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
