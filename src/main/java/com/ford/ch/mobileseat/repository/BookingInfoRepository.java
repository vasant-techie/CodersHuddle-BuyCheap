package com.ford.ch.mobileseat.repository;

import com.ford.ch.mobileseat.model.BookingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookingInfo, Integer>
{

    List<BookingInfo> findByDateAndCdsIdAndIsActive(String date, String cdsid, boolean isActive);

    List<BookingInfo> findByDateAndSeatIdAndIsActive(String date, String seatId, boolean b);

    //List<BookingInfo> findByStartDateBeforeAndEndDateAfter(String date, String seatId, boolean b);
}
