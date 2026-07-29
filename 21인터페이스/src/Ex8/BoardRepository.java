package Ex8;

public interface BoardRepository {

	int MAX_SIZE = 100;
	
	boolean insert(Board board);
	
	Board[] selectAll();
	
	Board selectOne(int boardId);
	
	boolean update(int boardId, String newContent);

	boolean delete(int boardId);
}


