package edittextlistener.ifpb.edu.br.edittextlistenerapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.R;
import edittextlistener.ifpb.edu.br.edittextlistenerapp.entity.User;

/**
 * Created by rerissondaniel on 05/03/16.
 */
public class UserDetailActivity extends Activity {

    @Bind(R.id.tv_id)
    protected TextView tvId;

    @Bind(R.id.tv_name)
    protected TextView tvName;

    @Bind(R.id.tv_email)
    protected TextView tvEmail;

    @Bind(R.id.tv_type_inscription)
    protected TextView tvTypeInscription;

    @Bind(R.id.tv_delivered)
    protected TextView tvDelivered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);

        User user = (User) getIntent().getParcelableExtra("user");
        Log.i("KDSJFNKSDJ", user.toString());
        tvId.setText(user.getId().toString());
        tvEmail.setText(user.getEmail());
        tvName.setText(user.getFullName());
        tvTypeInscription.setText(user.getTypeInscription());

        tvDelivered.setText(user.getIsDelivered() ? "Entregue" : "Não entregue");
    }
}
