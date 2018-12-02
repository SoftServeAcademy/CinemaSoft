package softServe.academy.cinemasoft.models.view;

import java.util.ArrayList;
import java.util.List;

public class AddMovieViewModel {
	
	    private String id;
		private ArrayList<String> comments;

		public AddMovieViewModel() {
	        this.comments = new ArrayList<String>();
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	
	}


