/**
 * Created by kaven on 2018/9/15.
 */
import java.util.Scanner;
public class Answer{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getResult(str));
    }
    public static String getResult(String str){
        String result = "";
        int beforeCount = 1;
        int afterCount = 1;
        boolean flag = false;
        int remark = 0;
        for(int i = 0; i < str.length() - 1; i++) {
            String _res = str.charAt(i) + "";
            char str_first = str.charAt(i);
            for(int j = i+1; j < str.length(); j++) {
                char str_next = str.charAt(j);
                if(str_first == str_next){
                    _res += str_next;
                    flag = true;
                    beforeCount += 1;
                }else{
                    if(beforeCount > 1){
                        if(j + beforeCount <= str.length() - 1){
                            remark = j + 1;
                            char str_after = str.charAt(remark);
                            if(str_after != str_next){
                                _res += str_next;
                                while(remark < j + beforeCount){
                                    if(str.charAt(remark) == str.charAt(remark + 1)) {
                                        _res += str.charAt(remark);
                                        if(remark == j + beforeCount - 1) {
                                            _res += str.charAt(remark + 1);
                                        }
                                    }else{
                                        _res = "";
                                    }
                                    remark += 1;
                                }

                                if(_res.length() > result.length()) {
                                    result = _res;
                                }

                            }
                        }
                    }
                  beforeCount = 1;
                }
            }
        }
        return result;
    }
}
