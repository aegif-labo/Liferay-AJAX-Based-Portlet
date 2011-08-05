create table rr_Reservation (
	reservationId INTEGER not null primary key,
	companyId LONG,
	groupId LONG,
	roomId INTEGER,
	ownerId LONG,
	beginTime DATE null,
	endTime DATE null,
	userId LONG,
	note VARCHAR(75) null
);

create table rr_Room (
	roomId INTEGER not null primary key,
	companyId LONG,
	groupId LONG,
	ownerId LONG,
	name VARCHAR(75) null,
	capacity INTEGER,
	available BOOLEAN
);