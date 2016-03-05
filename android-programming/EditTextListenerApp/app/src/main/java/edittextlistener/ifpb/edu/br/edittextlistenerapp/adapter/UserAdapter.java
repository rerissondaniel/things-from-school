package edittextlistener.ifpb.edu.br.edittextlistenerapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.R;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.entity.User;

/**
 * Created by rerissondaniel on 05/03/16.
 */
public class UserAdapter extends BaseAdapter {
    private ArrayList<User> mUsers;
    private LayoutInflater mInflater;

    public UserAdapter(Context context) {
        mInflater =
                (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mUsers = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return mUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        view = mInflater.inflate(R.layout.item_list_user, parent, false);

        ViewHolder holder = new ViewHolder(view);

        User user = mUsers.get(position);

        holder.tvId.setText(user.getId().toString());
        holder.typeInscription.setText(user.getTypeInscription());
        holder.tvEmail.setText(user.getEmail());
        holder.tvName.setText(user.getFullName());
        holder.cbIsDelivered.setSelected(user.getIsDelivered());

        return view;
    }

    static class ViewHolder {
        @Bind(R.id.tv_id)
        protected TextView tvId;

        @Bind(R.id.tv_type_inscription)
        protected TextView typeInscription;

        @Bind(R.id.tv_name)
        protected TextView tvName;

        @Bind(R.id.tv_email)
        protected TextView tvEmail;

        @Bind(R.id.cb_is_delivered)
        protected CheckBox cbIsDelivered;

        public ViewHolder(View v) {
            ButterKnife.bind(this, v);
        }
    }

    public void updateData(List<User> users) {
        mUsers.clear();
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    public ArrayList<User> getmUsers() {
        return mUsers;
    }

    public void setmUsers(ArrayList<User> mUsers) {
        this.mUsers = mUsers;
    }
}
