/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  kolis
 * Created: 21-Jun-2017
 */
update results_semester_two 
set Grade = 
CASE
WHEN examsscore >= 70 THEN 'A'
WHEN examsscore>=61 and examsscore <= 69 THEN 'B'
WHEN examsscore >=50 and examsscore <=60 THEN 'C'
WHEN examsscore >=45 and examsscore <= 49 THEN 'D'
WHEN examsscore >=41 and examsscore <= 44 THEN 'E'
ELSE 'F'
END;
