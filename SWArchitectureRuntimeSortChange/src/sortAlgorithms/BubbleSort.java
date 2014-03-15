package sortAlgorithms;

public class BubbleSort implements Isort {

	@Override
	public void sort(int[] data) {
		// 데이터 길이만큼 loop
		for(int i=1 ; i<data.length ; i++) {
			// 끝에서부터 채워지므로 카운트다운을 역으로 한다.
			for(int j=(data.length-1) ; j>0; j--)
			{
				// 만약 앞의 원소가 뒤의 원소보다 크다면
				if ( data[j - 1] > data[j] ) {
					// swap data
					int temp = data[j - 1];
					data[j - 1] = data[j];
					data[j] = temp;
				}
			}
		}
	}
}
