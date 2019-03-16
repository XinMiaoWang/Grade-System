# Grade-System-Project
[Grade-System (Version1)-介紹](https://hackmd.io/s/Sk3ylva84)

### User Manual 使用手冊

本成績系統讀入全班成績有 lab1, lab2, lab3, midterm, final exam 等成績，預設各成績的配分為0.1, 0.1, 0.1, 0.3, 0.4，依配分算出總成績建檔後，供使用者輸入指令查詢成績及排名，也可更改各個成績的配分。

  系統主要畫面如下，以使用者 "962001051 李威廷" 模擬操作過程

  1. 使用者登入

         螢幕顯示：輸入ID或 Q (結束使用)？
         本機輸入：962001051
         此時，系統會進行關閉。
         螢幕顯示：Welcome 李威廷
                   輸入指令 1) G 顯示成績 (Grade)
                           2) R 顯示排名 (Rank)
                           3) W 更新配分 (Weight)
                           4) E 離開選單 (Exit)
2. 輸入指令 G 可查詢成績。

       本機輸入：G
       螢幕顯示：李威廷成績：lab1：     81
                           lab2：     98
                           lab3：     84
                           mid-term :  90
                           final exam:  93
                           total grade :  91
                             
3. 輸入指令 R 可顯示成績排名。

       本機輸入：R
       螢幕顯示：李威廷排名第22
       
4. 輸入指令 W 可更新配分並重新計算成績。

       本機輸入：W
       螢幕顯示：舊配分 
                 lab1           10%
                 lab2           10%
                 lab3           10%
                 mid-term       30%
                 final exam     40%
         輸入新配分
                 lab1           20
                 lab2           20
                 lab3           20
                 mid-term       20
                 final exam     20
         請確認新配分
                 lab1           20%
                 lab2           20%
                 lab3           20%
                 mid-term       20%
                 final exam     20%
                 以上正確嗎? Y (Yes) 或 N (No)
         本機輸入：Y
       
       此操作會讓所有人的成績根據新配分重新計算，排名也會更新。反之若輸入N，則取消這次操作並跳回清單。
 
5. 輸入指令 E ，使用者登出；輸入指令 Q 離開系統。

       螢幕顯示：輸入指令 1) G 顯示成績 (Grade)
                        2) R 顯示排名 (Rank)
                        3) W 更新配分 (Weight)
                        4) E 離開選單 (Exit)
       本機輸入：E
       螢幕顯示：輸入ID或 Q (結束使用)？
       本機輸入：Q
       螢幕顯示：結束了
       
6. 使用者在登入後，可以不斷地輸入上述指令，直到輸入 E (登出)。

### Acceptance Test Cases (紅色表示使用者輸入) 驗收測試案例

 1.     螢幕顯示：輸入ID或 Q (結束使用)？ Q
        螢幕顯示：結束了
    
 2. 
        螢幕顯示：輸入ID或 Q (結束使用)？ 962001051
        螢幕顯示：Welcome 李威廷
        輸入指令 1) G 顯示成績 (Grade) 
                2) R 顯示排名 (Rank) 
                3) W更新配分 (Weight) 
                4) E 離開選單 (Exit)  
        使用者輸入： E 

        螢幕顯示：輸入ID或 Q (結束使用)？ Q
        螢幕顯示：結束了
    
3. 開始至輸入指令如上

       使用者輸入： G 
       螢幕顯示：李威廷成績：
              lab1：     81　
              lab2：     98　
              lab3：     84　
              midterm :  90
              final exam：93 
              total grade : 91          
              輸入指令如上
       使用者輸入： E 

       螢幕顯示：輸入ID或 Q (結束使用)？ Q
       螢幕顯示：結束了

4. 開始至輸入指令如上

        使用者輸入： R
        螢幕顯示：李威廷排名第22

        輸入指令如上
        使用者輸入：W
        螢幕顯示  舊配分 
                    lab1           10%
                    lab2           10%
                    lab3           10%
                    mid-term       30%
                    final exam      40%
                輸入新配分
                    lab1           20
                    lab2           20
                    lab3           20
                    mid-term       20
                    final exam      20
                請確認新配分
                    lab1           20%
                    lab2           20%
                    lab3           20%
                    mid-term       20%
                    final exam      20%
                以上正確嗎? Y (Yes) 或 N (No)
        使用者輸入：Y
      
 5.     螢幕顯示：輸入ID或 Q (結束使用)？ 123456789
        螢幕顯示：ID錯了!

 6.     螢幕顯示：輸入ID或 Q (結束使用)？ 962001051
        使用者輸入： K 
        螢幕顯示：指令錯了!
        
7. 開始至輸入指令如上

        使用者輸入： R
        螢幕顯示：李威廷排名第22 

8. 輸入指令如上

        使用者輸入：W
        螢幕顯示  舊配分 
            lab1           10%
            lab2           10%
            lab3           10%
            mid-term       30%
            final exam     40%
            輸入新配分
            lab1           20
            lab2           20
            lab3           20
            mid-term       20
            final exam     20
            請確認新配分
            lab1           20%
            lab2           20%
            lab3           20%
            mid-term       20%
            final exam     20%
            以上正確嗎? Y (Yes) 或 N (No)
        使用者輸入：Y
        螢幕顯示：輸入指令 1) G 顯示成績 (Grade) 
                         2) R 顯示排名 (Rank) 
                         3) W更新配分 (Weight) 
                         4) E 離開選單 (Exit)
        使用者輸入：R
        螢幕顯示：李威廷排名第33
  
