-- INSERT INTO public.user(email, password, creation_time)
-- VALUES ('alamakota@gamil.com', 'password', localtimestamp);
--
-- INSERT INTO public.candidate(age, description, first_name, last_name, location, phone_number, working_time)
-- VALUES ('18', 'looking for part time job', 'Robert', 'Kowalewski', 'Krakow', '508105752', 'weekends only');
--
-- UPDATE public.user
-- SET candidate_id = 1
-- WHERE id = 1;

INSERT INTO public.employer(company_name, industry, location, position, salary,
                            working_time)
VALUES ('ComPany', 'gastronomy', 'Warsaw', 'cook', 2100, 'five times a week')
