package ghsoft.yenhyia_chatmeetdating;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import link.fls.swipestack.SwipeStack;

public class HomeFragment extends Fragment {
    private SwipeStack cardStack;
    private CardsAdapter cardsAdapter;
    private ArrayList<CardItem> cardItems;
    private View btnCancel;
    private View btnLove;
    private int currentPosition;

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        menu.clear();
        inflater.inflate(R.menu.main_menu,menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().findViewById(R.id.my_toolbar).setVisibility(View.VISIBLE);

        cardStack = v.findViewById(R.id.card_container);
        btnCancel = v.findViewById(R.id.cancel);
        btnLove = v.findViewById(R.id.love);

        setCardStackAdapter();
        currentPosition = 0;

        //Handling swipe event of Cards stack
        cardStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {
                currentPosition = position + 1;
            }

            @Override
            public void onViewSwipedToRight(int position) {
                currentPosition = position + 1;
            }

            @Override
            public void onStackEmpty() {

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardStack.swipeTopViewToRight();
            }
        });

        btnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "You liked " + cardItems.get(currentPosition).getName(),
                        Toast.LENGTH_SHORT).show();
                cardStack.swipeTopViewToLeft();
            }
        });
        return v;
    }
    private void setCardStackAdapter() {
        cardItems = new ArrayList<>();

        cardItems.add(new CardItem(R.drawable.a, "Angela", "Hottie"));
        cardItems.add(new CardItem(R.drawable.f, "Selena", "Gomez"));
        cardItems.add(new CardItem(R.drawable.g, "Dorothy", "Amy"));
        cardItems.add(new CardItem(R.drawable.e, "Lyanna", "Stark"));
        cardItems.add(new CardItem(R.drawable.c, "Lydia", "Williewetty"));
        cardItems.add(new CardItem(R.drawable.d, "Diamond", "Waters"));
        cardItems.add(new CardItem(R.drawable.b, "Liana", "Ying"));

        cardsAdapter = new CardsAdapter(getActivity(), cardItems);
        cardStack.setAdapter(cardsAdapter);
    }


}
