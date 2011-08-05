create index IX_46337AB3 on rr_Reservation (beginTime);
create index IX_4CD91C25 on rr_Reservation (endTime);
create index IX_936D6957 on rr_Reservation (groupId);
create index IX_9710C9 on rr_Reservation (groupId, beginTime, endTime);
create index IX_3C939705 on rr_Reservation (groupId, roomId, beginTime);
create index IX_C6D824F7 on rr_Reservation (groupId, roomId, endTime);
create index IX_B1512EDB on rr_Reservation (groupId, roomId, userId);
create index IX_A26B26FD on rr_Reservation (roomId);

create index IX_427ACB59 on rr_Room (available);
create index IX_248E3CA on rr_Room (groupId);
create index IX_2F82349F on rr_Room (name);