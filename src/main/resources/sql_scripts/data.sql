insert into messenger_db.user (name, language_id, password)
values ('Mark', 94, md5(rand()));
insert into messenger_db.user (name, language_id, gender_id, password)
values ('Hana', 94, 2, md5(rand()));
insert into messenger_db.user (name, age_id, language_id, password)
values ('Parsifal', 2, 94, md5(rand()));
insert into messenger_db.user (name, age_id, gender_id, language_id, password)
values ('Bob', 2, 1, 94, md5(rand()));

insert into messenger_db.dialog (type_id)
values (1);
insert into messenger_db.dialog (type_id)
values (1);

insert into messenger_db.dialog_participant (dialog_id, user_id)
values (1, 1);
insert into messenger_db.dialog_participant (dialog_id, user_id)
values (1, 2);

insert into messenger_db.message (dialog_id, user_id, created_at, content)
values (1, 1, current_timestamp(), 'hello');
insert into messenger_db.message (dialog_id, user_id, created_at, content)
values (1, 1, current_timestamp(), 'hello again');
insert into messenger_db.message (dialog_id, user_id, created_at, content)
values (1, 2, current_timestamp(), 'reply');
