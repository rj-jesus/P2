package pt.ua.prog;

public class Agenda {
	private Nota[] notes;
	
	public void printNotes(){
		System.out.print("Agenda:\n");
		for(int i = 0; i < notes.length; i++) notes[i].printNote();
	}
	private void orderNotes(){
		for(int i = 0; i < notes.length - 1; i++){
			for(int j = i + 1; j < notes.length; j++){
				if(notes[i].begin().greaterThan(notes[j].begin())){
					Nota tmp = notes[i];
					notes[i] = notes[j];
					notes[j] = tmp;
				}
			}
		}
	}
	public Nota[] appointments(Data begin, Data end){
		if(begin.greaterThan(end)) throw new AssertionError("Error: Can't have an ending date earlier than the begining.");
		Nota[] a = null;
		for(int i = 0; i < notes.length; i++){
			//if(notes[i].begin().greaterThan(begin) && notes[i].begin().lessThan(end) || notes[i].end().greaterThan(begin) && notes[i].end().lessThan(end) || notes[i].begin().equalsTo(begin) || notes[i].end().equalsTo(begin) || notes[i].begin().equalsTo(end) || notes[i].end().equalsTo(end)){
			if(!(notes[i].end().lessThan(begin) || notes[i].begin().greaterThan(end))){
				a = expandList(a);
				a[a.length - 1] = notes[i];
			}
		}
		return a;
	}
	public void newNote(Nota a){
		notes = expandList(notes);
		notes[notes.length - 1] = a;
		orderNotes();
	}
	public Nota[] expandList(Nota[] a){
		Nota[] b = null;
		if(a == null){
			b = new Nota[1];
		}
		else{
			b = new Nota[a.length + 1];
			for(int i = 0; i < a.length; i++) b[i] = a[i];
		}
		return b;
	}
}

