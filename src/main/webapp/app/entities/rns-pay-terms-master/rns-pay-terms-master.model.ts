import { BaseEntity } from './../../shared';

export class RNS_PAY_TERMS_MASTER implements BaseEntity {
    constructor(
        public id?: number,
        public pAYTERMSCODE?: string,
        public pAYTERMSCODEDESC?: string,
    ) {
    }
}
