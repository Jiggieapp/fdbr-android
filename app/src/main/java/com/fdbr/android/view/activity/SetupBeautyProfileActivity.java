package com.fdbr.android.view.activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fdbr.android.App;
import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.model.PredefinedModel;
import com.fdbr.android.presenter.implementation.AccountPresenterImplementation;
import com.fdbr.android.utils.Constant;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.interfaces.AccountView;
import com.fdbr.android.view.widget.FlowLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LTE on 9/1/2016.
 */
public class SetupBeautyProfileActivity extends BaseActivity{

    @BindView(R.id.fl_skin_type)
    FlowLayout flSkinType;
    @BindView(R.id.fl_skin_tone)
    FlowLayout flSkinTone;
    @BindView(R.id.fl_skin_undertone)
    FlowLayout flSkinUndertone;
    @BindView(R.id.fl_hr_type)
    FlowLayout flHrType;
    @BindView(R.id.rel_next)
    RelativeLayout relNext;
    @BindView(R.id.fl_hr_tx)
    FlowLayout flHrTx;

    private final int TAG_SKIN_TYPE = 1;
    private final int TAG_SKIN_TONE = 2;
    private final int TAG_SKIN_UNDERTONE = 3;
    private final int TAG_HAIR_TYPE = 4;
    private final int TAG_HAIR_TX = 5;


    private Set<String> selectedItemsSkinType = new HashSet<>();
    private Set<String> selectedItemsSkinTone = new HashSet<>();
    private Set<String> selectedItemsSkinUndertone = new HashSet<>();
    private Set<String> selectedItemsHairType = new HashSet<>();
    private Set<String> selectedItemsHairTx = new HashSet<>();

    String[] sk_type = {"Tag a", "Tag b", "Tag c"};
    String[] sk_tone = {"Tag a", "Tag b", "Tag c"};
    String[] sk_undertone = {"Tag a", "Tag b", "Tag c"};
    String[] hk_type = {"Tag a", "Tag b", "Tag c"};
    String[] hk_tx = {"Tag a", "Tag b", "Tag c"};

    private static final String TAG = SetupBeautyProfileActivity.class.getSimpleName();

    PredefinedModel predefinedModel;
    PredefinedModel.Data data;
    protected void onCreate() {

        initView();

        String predefined = App.getInstance().getFromPreference(Constant.PREDEFINED);
        predefinedModel = new Gson().fromJson(predefined, PredefinedModel.class);

        data = predefinedModel.getData();
        setupTagSkinType(data.getSkin_type());
        setupTagSkinTone(data.getSkin_tone());
        setupTagSkinUndertone(data.getSkin_undertone());
        setupTagHairType(data.getHair_type());
        setupTagHairTx(data.getHair_texture());
    }

    private void initView() {
        getSupportActionBar().setTitle(Utils.getStringResource(this, R.string.setup_tag1));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupTagSkinType(ArrayList<PredefinedModel.Data.Skin_type> data) {
        final LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < data.size(); i++) {
            String nameTag = data.get(i).getSkityp_name();

            final View view = inflater.inflate(R.layout.item_setup_tag, flSkinType, false);
            final ViewHolder holder = new ViewHolder(SetupBeautyProfileActivity.this, view, nameTag, TAG_SKIN_TYPE);

            holder.textView.setText(holder.text);
            selectedItemsSkinType.add(nameTag);
            holder.container.setSelected(true);
            flSkinType.addView(view);

        }
    }

    private void setupTagSkinTone(ArrayList<PredefinedModel.Data.Skin_tone> data) {
        final LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < data.size(); i++) {
            String nameTag = data.get(i).getSkiton_name();

            final View view = inflater.inflate(R.layout.item_setup_tag, flSkinTone, false);
            final ViewHolder holder = new ViewHolder(SetupBeautyProfileActivity.this, view, nameTag, TAG_SKIN_TONE);

            holder.textView.setText(holder.text);
            selectedItemsSkinTone.add(nameTag);
            holder.container.setSelected(true);
            flSkinTone.addView(view);

        }
    }

    private void setupTagSkinUndertone(ArrayList<PredefinedModel.Data.Skin_undertone> data) {
        final LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < sk_undertone.length; i++) {
            String nameTag = data.get(i).getSkiund_name();

            final View view = inflater.inflate(R.layout.item_setup_tag, flSkinUndertone, false);
            final ViewHolder holder = new ViewHolder(SetupBeautyProfileActivity.this, view, nameTag, TAG_SKIN_UNDERTONE);

            holder.textView.setText(holder.text);
            selectedItemsSkinUndertone.add(nameTag);
            holder.container.setSelected(true);
            flSkinUndertone.addView(view);

        }
    }

    private void setupTagHairType(ArrayList<PredefinedModel.Data.Hair_type> data) {
        final LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < hk_type.length; i++) {
            String nameTag = data.get(i).getHaityp_name();

            final View view = inflater.inflate(R.layout.item_setup_tag, flHrType, false);
            final ViewHolder holder = new ViewHolder(SetupBeautyProfileActivity.this, view, nameTag, TAG_HAIR_TYPE);

            holder.textView.setText(holder.text);
            selectedItemsHairType.add(nameTag);
            holder.container.setSelected(true);
            flHrType.addView(view);

        }
    }

    private void setupTagHairTx(ArrayList<PredefinedModel.Data.Hair_texture> data) {
        final LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < hk_tx.length; i++) {
            String nameTag = data.get(i).getHaitex_name();

            final View view = inflater.inflate(R.layout.item_setup_tag, flHrTx, false);
            final ViewHolder holder = new ViewHolder(SetupBeautyProfileActivity.this, view, nameTag, TAG_HAIR_TX);

            holder.textView.setText(holder.text);
            selectedItemsHairTx.add(nameTag);
            holder.container.setSelected(true);
            flHrTx.addView(view);

        }
    }

    @Override
    public int getContentView() {
        return R.layout.activity_setup_beautyprofile;
    }


    @OnClick(R.id.rel_next)
    public void onClick() {
        Intent i = new Intent(SetupBeautyProfileActivity.this, SetupBeautyConcernActivity.class);
        i.putExtra(data.getClass().getName(), data);
        startActivity(i);
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

        public ViewHolder(final SetupBeautyProfileActivity activity, View parent, String text, final int TAG_TYPE) {
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
                case TAG_SKIN_TYPE:
                    this.selectedItemsSkinType.add(holder.text);
                    break;
                case TAG_SKIN_TONE:
                    this.selectedItemsSkinTone.add(holder.text);
                    break;
                case TAG_SKIN_UNDERTONE:
                    this.selectedItemsSkinUndertone.add(holder.text);
                    break;
                case TAG_HAIR_TYPE:
                    this.selectedItemsHairType.add(holder.text);
                    break;
                case TAG_HAIR_TX:
                    this.selectedItemsHairTx.add(holder.text);
                    break;
                default:
                    break;
            }

        } else {

            switch (TAG_TYPE) {
                case TAG_SKIN_TYPE:
                    if (this.selectedItemsSkinType.size() == 1) {
                        doNothing = true;
                        selected = false;
                    } else {
                        this.selectedItemsSkinType.remove(holder.text);
                    }
                    break;
                case TAG_SKIN_TONE:
                    if (this.selectedItemsSkinTone.size() == 1) {
                        doNothing = true;
                        selected = false;
                    } else {
                        this.selectedItemsSkinTone.remove(holder.text);
                    }
                    break;
                case TAG_SKIN_UNDERTONE:
                    if (this.selectedItemsSkinUndertone.size() == 1) {
                        doNothing = true;
                        selected = false;
                    } else {
                        this.selectedItemsSkinUndertone.remove(holder.text);
                    }
                    break;
                case TAG_HAIR_TYPE:
                    if (this.selectedItemsHairType.size() == 1) {
                        doNothing = true;
                        selected = false;
                    } else {
                        this.selectedItemsHairType.remove(holder.text);
                    }
                    break;
                case TAG_HAIR_TX:
                    if (this.selectedItemsHairTx.size() == 1) {
                        doNothing = true;
                        selected = false;
                    } else {
                        this.selectedItemsHairTx.remove(holder.text);
                    }
                    break;
                default:
                    break;
            }


        }

        if (!doNothing) {
            holder.checkView.setVisibility(selected ? View.VISIBLE : View.GONE);
            holder.container.setSelected(selected);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
