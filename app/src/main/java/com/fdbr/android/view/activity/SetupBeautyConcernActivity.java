package com.fdbr.android.view.activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fdbr.android.MainActivity;
import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.model.PredefinedModel;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.widget.FlowLayout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LTE on 9/1/2016.
 */
public class SetupBeautyConcernActivity extends BaseActivity {

    @BindView(R.id.fl_skin)
    FlowLayout flSkin;
    @BindView(R.id.fl_body)
    FlowLayout flBody;
    @BindView(R.id.fl_hair)
    FlowLayout flHair;
    @BindView(R.id.rel_done)
    RelativeLayout relDone;

    private final int TAG_SKIN = 1;
    private final int TAG_BODY = 2;
    private final int TAG_HAIR = 3;

    private Set<String> selectedItemsSkin = new HashSet<>();
    private Set<String> selectedItemsBody = new HashSet<>();
    private Set<String> selectedItemsHair = new HashSet<>();

    String[] arr_skin = {"Tag a", "Tag b", "Tag c"};
    String[] arr_body = {"Tag a", "Tag b", "Tag c"};
    String[] arr_hair = {"Tag a", "Tag b", "Tag c"};

    private static final String TAG = SetupBeautyConcernActivity.class.getSimpleName();
    private PredefinedModel.Data data;

    @Override
    protected void onCreate() {
        initView();

        data = getIntent().getParcelableExtra(PredefinedModel.Data.class.getName());

        setupTagSkin(data.getSkin_concerns());
        setupTagBody(data.getBody_concerns());
        setupTagHair(data.getHair_concerns());
    }

    @Override
    public int getContentView() {
        return R.layout.activity_setup_beautyconcern;
    }

    private void initView(){
        getSupportActionBar().setTitle(Utils.getStringResource(this, R.string.bc));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupTagSkin(ArrayList<PredefinedModel.Data.Skin_concern> data) {
        final LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < data.size(); i++) {
            String nameTag = data.get(i).getSkicon_name();

            final View view = inflater.inflate(R.layout.item_setup_tag, flSkin, false);
            final ViewHolder holder = new ViewHolder(SetupBeautyConcernActivity.this, view, nameTag, TAG_SKIN);

            holder.textView.setText(holder.text);
            /*selectedItemsSkin.add(arr_skin[i]);
            holder.container.setSelected(true);*/
            holder.checkView.setVisibility(View.GONE);
            flSkin.addView(view);

        }
    }

    private void setupTagBody(ArrayList<PredefinedModel.Data.Body_concern> data) {
        final LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < data.size(); i++) {
            String nameTag = data.get(i).getBodcon_name();

            final View view = inflater.inflate(R.layout.item_setup_tag, flBody, false);
            final ViewHolder holder = new ViewHolder(SetupBeautyConcernActivity.this, view, nameTag, TAG_BODY);

            holder.textView.setText(holder.text);
            /*selectedItemsBody.add(arr_body[i]);
            holder.container.setSelected(true);*/
            holder.checkView.setVisibility(View.GONE);
            flBody.addView(view);

        }
    }

    private void setupTagHair(ArrayList<PredefinedModel.Data.Hair_concern> data) {
        final LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < data.size(); i++) {
            String nameTag = data.get(i).getHaicon_name();

            final View view = inflater.inflate(R.layout.item_setup_tag, flHair, false);
            final ViewHolder holder = new ViewHolder(SetupBeautyConcernActivity.this, view, nameTag, TAG_HAIR);

            holder.textView.setText(holder.text);
            /*selectedItemsHair.add(arr_hair[i]);
            holder.container.setSelected(true);*/
            holder.checkView.setVisibility(View.GONE);
            flHair.addView(view);

        }
    }

    static class ViewHolder {

        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.checkView)
        ImageView checkView;
        @BindView(R.id.container)
        LinearLayout container;

        View parent;
        String text;
        private int TAG_TYPE = 0;

        public ViewHolder(final SetupBeautyConcernActivity activity, View parent, String text, final int TAG_TYPE) {
            ButterKnife.bind(this, parent);
            this.textView.setText(text);
            this.parent = parent;
            this.text = text;
            this.TAG_TYPE = TAG_TYPE;

            this.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (activity != null)
                        activity.onTagClick(ViewHolder.this, TAG_TYPE);
                }
            });
        }
    }

    private void onTagClick(ViewHolder holder, int TAG_TYPE) {
        boolean selected = holder.checkView.getVisibility() != View.VISIBLE;
        boolean doNothing = false;

        if (selected) {
            switch (TAG_TYPE) {
                case TAG_SKIN:
                    this.selectedItemsSkin.add(holder.text);
                    break;
                case TAG_BODY:
                    this.selectedItemsBody.add(holder.text);
                    break;
                case TAG_HAIR:
                    this.selectedItemsHair.add(holder.text);
                    break;
                default:
                    break;
            }

        }else {

            switch (TAG_TYPE){
                case TAG_SKIN:
                    if(this.selectedItemsSkin.size()==1){
                        doNothing = true;
                        selected = false;
                    }else{
                        this.selectedItemsSkin.remove(holder.text);
                    }
                    break;
                case TAG_BODY:
                    if(this.selectedItemsBody.size()==1){
                        doNothing = true;
                        selected = false;
                    }else{
                        this.selectedItemsBody.remove(holder.text);
                    }
                    break;
                case TAG_HAIR:
                    if(this.selectedItemsHair.size()==1){
                        doNothing = true;
                        selected = false;
                    }else{
                        this.selectedItemsHair.remove(holder.text);
                    }
                    break;
                default:
                    break;
            }


        }

        if(!doNothing){
            holder.checkView.setVisibility(selected ? View.VISIBLE : View.GONE);
            holder.container.setSelected(selected);
        }
    }

    @OnClick(R.id.rel_done)
    public void onClick() {
        startActivity(new Intent(SetupBeautyConcernActivity.this, MainActivity.class));
    }
}
