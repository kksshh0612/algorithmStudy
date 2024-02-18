-- 코드를 입력하세요
SELECT car.car_id, car.car_type, round(car.daily_fee * 30 * (100 - discount.discount_rate) / 100) as FEE
from CAR_RENTAL_COMPANY_CAR as car 
    inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY as history 
        on car.car_id = history.car_id 
    inner join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as discount
        on car.car_type = discount.car_type
where car.car_id not in (
        select car_id 
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
        where end_date >= '2022-11-01' and start_date < '2022-12-01'
    )
    and discount.DURATION_TYPE like '30%'
group by car.car_id
having (FEE >= 500000 and FEE < 2000000)
    and car.car_type in ('세단', 'SUV')
order by FEE desc, car.car_type, car.car_id desc

