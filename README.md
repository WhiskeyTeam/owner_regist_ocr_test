# owner_regist_ocr_test

사업자 등록증 ocr api 확인용 레포

- API의 결과값 중에 b_stt_cd라는 값이 01 이어야만 정상적으로 인증 완료하는 식으로 하면 될 것 같음


        * b_sst_cd 값의 의미
        * 01: 정상 (Normal) - 사업자가 정상적으로 등록되어 있는 상태입니다.
        * 02: 휴업 (Suspended) - 사업자가 휴업 중이거나 일시적으로 운영을 중단한 상태입니다.
        * 03: 폐업 (Closed) - 사업자가 폐업한 상태입니다.
        * 04: 미등록 (Not Registered) - 사업자가 등록되지 않은 상태입니다.
        * 05: 등록 취소 (Registration Cancelled) - 사업자 등록이 취소된 상태입니다.
