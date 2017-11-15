#include <iostream>
#include <vector>
using namespace std;

int cnt;

class queen{
	public: int x;
};

class board{
	private: vector<queen> array;
	public:
	void init_cnt(){cnt = 0;}
	void create_board(int n){
		int i;
		for (i=0; i<n; i++){
			queen temp;
			array.push_back(temp);
		}
	}
	void printsol(int n){
		int i,j;
		//Remove from comment if solution is to be displayed
		for (j=0; j<n; j++){
			for (i=0; i<n; i++){
				if (array[j].x==i)
					cout<<"Q";
				else cout<<"*";
			}
		cout<<"\n";
		}
		for (i=0;i<n;i++)
			cout<<array[i].x<<" ";
		cout<<"\n\n";

	}


	int check(int n, int qn)
	{
		int i;
		for (i=0; i<qn; i++)
		{
			if(array[qn].x == array[i].x || array[qn].x + qn == array[i].x + i || array[qn].x - qn == array[i].x - i)
				return 0;
		}
		return 1;
	}

	int create_sol(int n, int qn)
	{
		int next;
		if (n==qn)
			return 1;
		int i, thisone;
		for (i=0; i<n; i++){
			array[qn].x = i;
			thisone = check(n, qn);
			//cout<<qn<<" check done\n";
			if(thisone == 1){
				next = create_sol(n, qn+1);
			}
			if (next == 1  && thisone == 1){
				if(qn == n-1){
					cnt +=1;
					if (cnt%10000 == 0)
						cout<<cnt<<"\n";
					printsol(n);
				}
			}

		}
		return 1;
	}
};



int main()
{
	int n,i;
	cout<<"Enter n: ";
	cin>>n;
	board test;
	test.create_board(n);
	cout<<"Board Created\n";
	test.init_cnt();
	test.create_sol(n,0);
	cout<<"Total number of solutions: "<<cnt<<"\n\n";
	return 0;
}
