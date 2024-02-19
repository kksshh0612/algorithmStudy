-- 코드를 입력하세요
SELECT appointment.apnt_no, patient.pt_name, patient.pt_no, appointment.mcdp_cd, 
    doctor.dr_name, appointment.apnt_ymd
from appointment 
    inner join patient 
        on patient.pt_no = appointment.pt_no 
    inner join doctor 
        on appointment.mddr_id = doctor.dr_id
where appointment.mcdp_cd = 'CS' and appointment.apnt_ymd like '2022-04-13%' and 
    appointment.APNT_CNCL_YN = 'N'
order by appointment.apnt_ymd 