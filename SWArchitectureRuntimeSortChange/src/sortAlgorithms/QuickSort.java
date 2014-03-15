package sortAlgorithms;

public class QuickSort implements Isort {
	int[] data;
	
	@Override
	public void sort(int[] data) {
		
		this.data = data;
		// pivot 을 data의 마지막 값으로 한다.
		int pivotPosition = data.length - 1;

		quickSort(0, pivotPosition);
	}
	
	private void quickSort(int startPosition, int pivotPosition)
	{
		if (startPosition == pivotPosition || startPosition < 0 || pivotPosition >= data.length) {
			return;
		}
		
		int currentPosition = startPosition;
		int endOfLowBlock = startPosition - 1;
		
		while( currentPosition < pivotPosition ) {
			// 만약 현재 값이 pivot보다 크다면 놔둔다.
			if ( data[currentPosition] < data[pivotPosition] ) {
				// 만약 현재 값이 Pivot 보다 작다면 lowBlock + 1 위치 ( == Pivot보다 큰 값중 첫 번째 위치 )와 자리를 바꾸고 lowBlock 크기를 1 증가시킨다.
				int temp = data[endOfLowBlock + 1];
				data[endOfLowBlock + 1] = data[currentPosition];
				data[currentPosition] = temp;
				endOfLowBlock++;
			}
			
			currentPosition++;
		}
		// 루프가 끝나면 lowBlock + 1 자리와 Pivot을 바꾼다.
		int temp = data[endOfLowBlock + 1];
		data[endOfLowBlock + 1] = data[pivotPosition];
		data[pivotPosition] = temp;
		
		// recursive
		quickSort(startPosition, endOfLowBlock);
		quickSort(endOfLowBlock+1, pivotPosition);
	}
}
