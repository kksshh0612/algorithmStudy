-- 코드를 입력하세요
SELECT distinct car.car_id 
from car_rental_company_car as car 
    inner join car_rental_company_rental_history as history 
        on car.car_id = history.car_id 
where car.car_type = '세단' and history.start_date like '%-10-%'
order by car.car_id desc 
