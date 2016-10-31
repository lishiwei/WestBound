package com.lishiwei.westbund.Fragment.FragmentMapPkg;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lishiwei.core.ImageLoad;
import com.lishiwei.westbund.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMapFloor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMapFloor extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.photoView_MapFloor)
    PhotoView photoViewMapFloor;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentMapFloor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMapFloor.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMapFloor newInstance(String param1, String param2) {
        FragmentMapFloor fragment = new FragmentMapFloor();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try {
            final PhotoViewAttacher attacher = new PhotoViewAttacher(photoViewMapFloor);
            int imgUrl = 0;
            if (mParam1.equals("1"))
            {
                imgUrl = R.drawable.main_venue;
            }if (mParam1.equals("2"))
            {
                imgUrl = R.drawable.new_venue;
            }if (mParam1.equals("3"))
            {
                imgUrl = R.drawable.demonstration_area;
            }if (mParam1.equals("4"))
            {
                imgUrl = R.drawable.westbund_area;
            }
            ImageLoad.displayMapImageView(getActivity(), ""+imgUrl, photoViewMapFloor, new ImageLoad.PiccasoCallBack() {
                @Override
                public void onSuccess() {
                    attacher.update();
                }

                @Override
                public void onError() {

                }
            });
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_floor, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
