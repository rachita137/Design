package tatastrive.application.design;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Design extends Fragment {


    public Design() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View design_layout = inflater.inflate(R.layout.fragment_design, container, false);


        Button btn = design_layout.findViewById(R.id.design_btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Hi There Thank you",Toast.LENGTH_SHORT).show();
            }
        });


        return design_layout;
    }

}
