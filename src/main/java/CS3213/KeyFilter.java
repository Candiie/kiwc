import java.util.ArrayList;
import java.util.List;

public class KeyFilter {
	
	private List<String> _preFilteredTitles;
	private List<String> _filteredTitles;
	private List<String> _requiredWords;
	
	public KeyFilter (){
		_preFilteredTitles = new ArrayList<String>();
		_filteredTitles = new ArrayList<String>();
		_requiredWords = new ArrayList<String>();
	}
	
	public void setRequiredWords (List<String> tempReqWords){
		_requiredWords = tempReqWords;
	}
	
	//sets the list of original kwic list
	public void setKwicOriList(List<String> tempOriList){
		_preFilteredTitles = tempOriList;
	}
	
	
	public List<String> filterList(){
		
		for(String keyword: _requiredWords){
			
			for(String title: _preFilteredTitles){
				
				if(title.split(" ")[0].equals(keyword)){
					_filteredTitles.add(title);
				}	
			}
		}
		return _filteredTitles;
	}
	
	
	

}
