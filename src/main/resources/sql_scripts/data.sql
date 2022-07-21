-- ---------- testing uuids -----------
-- 0 66eb334f-2190-4b33-8406-24889aae4ceb
-- 1 d9cf3d94-674a-4d58-a0b4-97249af3a823
-- 2 ca275de2-bf40-4b4c-85b2-3ebf702e62ac
-- 3 86ef13a7-83cb-428b-aaf8-a3226635aaa0
-- 4 7b1e7671-bfc4-4668-b20c-578b1ae5dbd0
-- 5 49b85ff5-d826-4ffb-ac8d-de014f99b850
-- 6 56cd546e-f9a4-4c61-b409-8da01562438b
-- 7 347303c1-0ae5-4bdc-bc46-77a1f2a9dd11
-- 8 3366a8ac-19f7-460d-8b0a-eefca2123789
-- 9 a7137127-6430-490d-8102-b62d887d3020

insert into messenger_db.user (uuid, name, language_id)
values (uuid_to_bin('66eb334f-2190-4b33-8406-24889aae4ceb'), 'Mark', 94);
insert into messenger_db.user (uuid, name, language_id, gender_id)
values (uuid_to_bin('d9cf3d94-674a-4d58-a0b4-97249af3a823'), 'Hana', 94, 2);
insert into messenger_db.user (uuid, name, age_id, language_id)
values (uuid_to_bin('ca275de2-bf40-4b4c-85b2-3ebf702e62ac'), 'Parsifal', 2, 94);
insert into messenger_db.user (uuid, name, age_id, gender_id, language_id)
values (uuid_to_bin('86ef13a7-83cb-428b-aaf8-a3226635aaa0'), 'Bob', 2, 1, 94);

insert into messenger_db.dialog (uuid, type_id)
values (uuid_to_bin('7b1e7671-bfc4-4668-b20c-578b1ae5dbd0'), 1);
insert into messenger_db.dialog (uuid, type_id)
values (uuid_to_bin('49b85ff5-d826-4ffb-ac8d-de014f99b850'), 1);

insert into messenger_db.dialog_participant (dialog_uuid, user_uuid)
values (uuid_to_bin('7b1e7671-bfc4-4668-b20c-578b1ae5dbd0'), uuid_to_bin('66eb334f-2190-4b33-8406-24889aae4ceb'));
insert into messenger_db.dialog_participant (dialog_uuid, user_uuid)
values (uuid_to_bin('7b1e7671-bfc4-4668-b20c-578b1ae5dbd0'), uuid_to_bin('d9cf3d94-674a-4d58-a0b4-97249af3a823'));

insert into messenger_db.message (dialog_uuid, user_uuid, created_at, content)
values (uuid_to_bin('7b1e7671-bfc4-4668-b20c-578b1ae5dbd0'), uuid_to_bin('66eb334f-2190-4b33-8406-24889aae4ceb'),
        current_timestamp(), 'hello mysql');
insert into messenger_db.message (dialog_uuid, user_uuid, created_at, content)
values (uuid_to_bin('7b1e7671-bfc4-4668-b20c-578b1ae5dbd0'), uuid_to_bin('66eb334f-2190-4b33-8406-24889aae4ceb'),
        current_timestamp(), 'hello mysql again');
insert into messenger_db.message (dialog_uuid, user_uuid, created_at, content)
values (uuid_to_bin('7b1e7671-bfc4-4668-b20c-578b1ae5dbd0'), uuid_to_bin('d9cf3d94-674a-4d58-a0b4-97249af3a823'),
        current_timestamp(), 'reply');