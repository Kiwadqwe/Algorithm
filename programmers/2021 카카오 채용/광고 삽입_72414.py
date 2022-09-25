def solution(play_time, adv_time, logs):
    
    if play_time == adv_time:
        return "00:00:00"
    
    answer = ''
    time = [[0,0] for _ in range(len(logs))]
    adv_time = adv_time.split(':')
    adv = int(adv_time[0]) * 3600 + int(adv_time[1]) * 60 + int(adv_time[2])
    p = play_time.split(':')
    play_time = int(p[0]) * 3600 + int(p[1]) * 60 + int(p[2])
   
    dp = [0] * (play_time+1)
    
    for i in range(len(logs)):
        a,b = logs[i].split('-')

        a = a.split(':')
        b = b.split(':')

        a = int(a[0]) * 3600 + int(a[1]) * 60 + int(a[2])
        b = int(b[0]) * 3600 + int(b[1]) * 60 + int(b[2])
        
        time[i][0] = a
        time[i][1] = b
        dp[a] += 1
        dp[b] -= 1
            
    time.sort()
    
    for i in range(play_time):
        dp[i] = dp[i] + dp[i-1]
        
    for i in range(play_time):
        dp[i] = dp[i] + dp[i-1]
        
    m = -1
    for i in range(adv-1,play_time):
        temp = dp[i] - dp[i-adv]
        a = dp[i]
        b = dp[i-adv]
        if m < temp:
            m = temp
            answer  = i-adv+1
    
    y = answer//3600
    m = (answer % 3600) // 60
    s = (answer % 3600) % 60
    answer = str(y).zfill(2)+":"+ str(m).zfill(2)+":"+str(s).zfill(2)

    return answer
    
print(solution("02:03:55", "00:14:15", ["01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30", "01:30:59-01:53:29"]))