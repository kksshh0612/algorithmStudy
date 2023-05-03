#include <iostream>
#include <vector>
using namespace std;

int main() {
	int num = 0, copy_num = 0, div = 0;
	cin >> num;
	copy_num = num;			//num을 복사한 변수

	for (int i = 2; i * i <= num; i++) {
		while (copy_num % i == 0) {				//나누어 떨어질때 반복 
			cout << i << "\n";
			copy_num /= i;
		}
	}					
	if (copy_num > 1) {							//모두 나누었는데 나누어지지 않고 남았으면 이 수는 소수임. 
		cout << copy_num << "\n";
	}
	
	return 0;
}