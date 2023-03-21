input = int(input("Enter seconds: "))
# #seconds
# if (input<60):
#   print(input,"seconds is", input,"seconds.")
# #minutes
# elif(3600>input):
#   minute = input//60
#   seconds = input%60
#   print(input, "seconds is", minute,"minute(s) and", seconds,"seconds.")
# #hours
# elif(86400>input):
#   hours = input//3600
#   remainder_hr = input%3600
#   minutes = remainder_hr//60
#   seconds = remainder_hr%60
#   print(input, "seconds is", hours, "hour(s)", minutes,"minute(s) and", seconds,"seconds.")
# #days
# elif(604800>input):
#   days = input//86400
#   remainder_day = input%86400
#   hours = remainder_day//3600
#   remainder_hr = input%3600
#   minutes = remainder_hr//60
#   seconds = remainder_hr%60  
#   print(input, "seconds is", days,"day(s),", hours, "hour(s)", minutes,"minute(s) and", seconds,"seconds.")
# #weeks
# elif(2592000>input):
#   weeks = input // 604800
#   remainder_wk = input%604800
#   days = remainder_wk//86400
#   remainder_day = remainder_wk%86400
#   hours = remainder_day//3600
#   remainder_hr = input%3600
#   minutes = remainder_hr//60
#   seconds = remainder_hr%60  
#   print(input, "seconds is", weeks,"week(s),", days,"day(s),", hours, "hour(s)", minutes,"minute(s) and", seconds,"seconds.")
# #months
# elif(31536000>input):
#   months = input // 2592000
#   remainder_mo = input % 2592000
#   weeks = remainder_mo // 604800
#   remainder_wk = remainder_mo%604800
#   days = remainder_wk//86400
#   remainder_day = remainder_wk%86400
#   hours = remainder_day//3600
#   remainder_hr = input%3600
#   minutes = remainder_hr//60
#   seconds = remainder_hr%60  
#   print(input, "seconds is", months, "month(s)", weeks,"week(s),", days,"day(s),", hours, "hour(s)", minutes,"minute(s) and", seconds,"seconds.")
# elif(31536000>input):
#   months = input // 2592000
#   remainder_mo = input % 2592000
#   weeks = remainder_mo // 604800
#   remainder_wk = remainder_mo%604800
#   days = remainder_wk//86400
#   remainder_day = remainder_wk%86400
#   hours = remainder_day//3600
#   remainder_hr = input%3600
#   minutes = remainder_hr//60
#   seconds = remainder_hr%60  
#   print(input, "seconds is", months, "month(s)", weeks,"week(s),", days,"day(s),", hours, "hour(s)", minutes,"minute(s) and", seconds,"seconds.")
# else:
#   years = input // 31536000
#   remainder_yr = input % 31536000
#   months = remainder_yr // 2592000
#   remainder_mo = remainder_yr % 2592000
#   weeks = remainder_mo // 604800
#   remainder_wk = remainder_mo%604800
#   days = remainder_wk//86400
#   remainder_day = remainder_wk%86400
#   hours = remainder_day//3600
#   remainder_hr = input%3600
#   minutes = remainder_hr//60
#   seconds = remainder_hr%60  
#   print(input, "seconds is", years, "year(s)", months, "month(s)", weeks,"week(s),", days,"day(s),", hours, "hour(s)", minutes,"minute(s) and", seconds,"seconds.")

years = input // 31536000
remainder_yr = input % 31536000
months = remainder_yr // 2592000
remainder_mo = remainder_yr % 2592000
weeks = remainder_mo // 604800
remainder_wk = remainder_mo % 604800
days = remainder_wk // 86400
remainder_day = remainder_wk % 86400
hours = remainder_day // 3600
remainder_hr = input % 3600
minutes = remainder_hr // 60
seconds = remainder_hr % 60
print(input, "seconds is", years, "year(s)", months, "month(s)", weeks, "week(s),", days, "day(s),", hours, "hour(s)",
      minutes, "minute(s) and", seconds, "seconds.")
